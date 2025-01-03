 import {useAuth} from "../../../auth/context/AuthContext";
import {useEffect, useState} from "react";
import MessageModel from "../../../models/MessageModel";
import {SpinnerLoading} from "../../Utils/SpinnerLoading";
import {Pagination} from "../../Utils/Pagination";
import {AdminMessage} from "./AdminMessage";
import AdminMessageRequest from "../../../models/AdminMessageRequest";

export const AdminMessages = () => {

    const {user, token} = useAuth();

    //Normal Loading Pieces
    const [isLoadingMessages, setIsLoadingMessages] = useState(true);
    const [httpError, setHttpError] = useState(null);

    //Messages endpoint State
    const [messages, setMessages] = useState<MessageModel[]>([]);
    const [messagesPerPage] = useState(5);

    //Pagination
    const [currentPage, setCurrentPage] = useState(1);
    const [totalPages, setTotalPages] = useState(0);

    // Recall useEffect
    const [buttonSubmit, setButtonSubmit] = useState(false);

    useEffect(() => {
        const fetchUserMessages = async () => {
            if (user) {
                const url = `${process.env.REACT_APP_API}/messages/search?page=${currentPage - 1}&size=${messagesPerPage}`;
                const requestOptions = {
                    method: 'GET',
                    headers: {
                        Authorization: `Bearer ${token}`,
                        'Content-Type': 'application/json'
                    }
                };
                const messagesResponse = await fetch(url, requestOptions);

                if (!messagesResponse.ok) {
                    throw new Error('Something went wrong!');
                }

                const messagesResponseJson = await messagesResponse.json();

                setMessages(messagesResponseJson.content);
                setTotalPages(messagesResponseJson.totalPages);
            }
            setIsLoadingMessages(false);
        }

        fetchUserMessages().catch((error: any) => {
            setIsLoadingMessages(false);
            setHttpError(error.message);
        })
        window.scrollTo(0, 0);
    }, [user, token, currentPage, buttonSubmit]);

    if (isLoadingMessages) {
        return (
            <SpinnerLoading/>
        );
    }

    if (httpError) {
        return (
            <div className='container m-5'>
                <p>{httpError}</p>
            </div>
        )
    }

    async function submitResponseToQuestion(id: number, response:string){
            const url = `${process.env.REACT_APP_API}/messages/secure/admin/message`;
            if (user && id !== null && response !== ''){
                const messageAdminRequestModel: AdminMessageRequest = new AdminMessageRequest(id, response);
                const requestOptions = {
                    method: 'PUT',
                    headers: {
                        Authorization: `Bearer ${token}`,
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(messageAdminRequestModel)
                };
                const messageAdminRequestModelResponse = await fetch(url, requestOptions);
                if (!messageAdminRequestModelResponse.ok){
                    throw new Error('Something went wrong!');
                }
                setButtonSubmit(!buttonSubmit);


            }
    }

    const paginate = (pageNumber: number) => setCurrentPage(pageNumber);

    return (
        <div className='mt-3'>
            {messages.length > 0 ?
                <>
                    <h5>Pending Q/A: </h5>
                    {messages.map(message => (
                        <AdminMessage message={message} key={message.id} submitResponseToQuestion={submitResponseToQuestion}/>
                    ))}
                </>
                :
                <h5>No pending Q/A</h5>
            }
            {totalPages > 1 && <Pagination currentPage={currentPage} totalPages={totalPages} paginate={paginate}/>}
        </div>
    )
}