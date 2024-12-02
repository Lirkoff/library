import React, {useState, useEffect} from 'react';
import '@fortawesome/fontawesome-free/css/all.css'
import {
    MDBTabs,
    MDBTabsItem,
    MDBTabsLink,
    MDBTabsContent,
    MDBTabsPane
} from 'mdb-react-ui-kit';
import {LoginForm} from "./Components/LoginForm";
import {RegisterForm} from "./Components/RegisterForm";
import {useLocation} from "react-router-dom";




export const LoginRegisterPage = () => {
    const location = useLocation();
    const isRegister = location.pathname === '/register';
    const [isActive, setIsActive] = useState('tab1');



    const handleBasicClick = (value: string) => {
        if (value === isActive) {
            return;
        }

        setIsActive(value);
    };



    useEffect(() => {
        if (isRegister) {
            setIsActive('tab2');
        }
    }, []);



    return (
        <div className='container'>
            <div className='row justify-content-center'>
                <div className='col-md-10 col-lg-4 col-xl-4 m-5 p-5 border border-dark rounded-3 main-color'>
                    <MDBTabs justify className={'border-0'}>
                        <MDBTabsItem>
                            <MDBTabsLink
                                className={isActive === 'tab1' ? 'container bg-transparent text-white' : 'container main-color text-white'}
                                onClick={() => handleBasicClick('tab1')} active={isActive === 'tab1'}>
                                Login
                            </MDBTabsLink>
                        </MDBTabsItem>
                        <MDBTabsItem>
                            <MDBTabsLink
                                className={isActive === 'tab2' ? 'container bg-transparent text-white' : 'container main-color  text-white'}
                                onClick={() => handleBasicClick('tab2')} active={isActive === 'tab2'}>
                                Register
                            </MDBTabsLink>
                        </MDBTabsItem>
                    </MDBTabs>
                    <MDBTabsContent>
                        <MDBTabsPane open={isActive === 'tab1'}><LoginForm/></MDBTabsPane>
                        <MDBTabsPane open={isActive === 'tab2'}><RegisterForm/></MDBTabsPane>
                    </MDBTabsContent>
                </div>
            </div>
        </div>
    );
}
