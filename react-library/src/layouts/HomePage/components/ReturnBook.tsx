import React from "react";
import BookModel from "../../../models/BookModel";
import {Link} from "react-router-dom";

export const ReturnBook: React.FC<{book: BookModel}> = (props) => {
    const baseURL = 'https://localhost:8443';
    return (
        <div className='col-xs-6 col-sm-6 col-md-4 col-lg-3 mb-3'>
            <div className='text-center'>
                {props.book.img ?
                    <img src={baseURL + props.book.img}
                         width='151'
                         height='233'
                         alt="book"
                    />
                    :
                    <img src={require('../../../Images/BooksImages/book.webp')}
                         width='151'
                         height='233'
                         alt="book"
                    />
                }
                <h6 className='mt-2'>{props.book.title}</h6>
                <p>{props.book.author}</p>
                <Link to={`checkout/${props.book.id}`} className='btn main-color text-white' href='#'>Reserve</Link>
            </div>
        </div>
    );
}