import './App.css';
import {Navbar} from "./layouts/NavbarAndFooter/Navbar";
import {Footer} from "./layouts/NavbarAndFooter/Footer";
import {HomePage} from "./layouts/HomePage/HomePage";
import {SearchBooksPage} from "./layouts/SearchBooksPage/SearchBooksPage";
import {BookCheckoutPage} from "./layouts/BookCheckoutPage/BookCheckoutPage";
import {Redirect, Route, Switch} from "react-router-dom";
import React from "react";
import {LoginRegisterPage} from "./auth/LoginPage/LoginRegisterPage";
import {AuthProvider} from "./auth/context/AuthContext";
import PrivateRoute from "./auth/PrivateRoute";
import {ReviewListPage} from "./layouts/BookCheckoutPage/ReviewListPage/ReviewListPage";
import {ShelfPage} from "./layouts/ShelfPage/ShelfPage";
import {MessagesPage} from "./layouts/MessagesPage/MessagesPage";
import {ManageLibraryPage} from "./layouts/ManageLibraryPage/ManageLibraryPage";
import {PaymentPage} from "./layouts/PaymentPage/PaymentPage";


export const App: React.FC = () => {
    return (
        <div className='d-flex flex-column min-vh-100'>
            <AuthProvider>
                    <Navbar/>
                    <div className='flex-grow-1'>
                        <Switch>
                            <Route path='/' exact>
                                <Redirect to='/home'/>
                            </Route>
                            <Route path='/home'>
                                <HomePage/>
                            </Route>
                            <Route path='/search'>
                                <SearchBooksPage/>
                            </Route>
                            <Route path='/reviewlist/:bookId'>
                                <ReviewListPage/>
                            </Route>
                            <Route path='/checkout/:bookId'>
                                <BookCheckoutPage/>
                            </Route>
                            <Route path='/login'>
                                <LoginRegisterPage/>
                            </Route>
                            <Route path='/register'>
                                <LoginRegisterPage/>
                            </Route>
                            <PrivateRoute path='/shelf'>
                                <ShelfPage/>
                            </PrivateRoute>
                            <PrivateRoute path='/messages'>
                                <MessagesPage/>
                            </PrivateRoute>
                            <PrivateRoute path='/admin'>
                                <ManageLibraryPage/>
                            </PrivateRoute>
                            <PrivateRoute path='/fees'>
                                <PaymentPage/>
                            </PrivateRoute>
                        </Switch>
                    </div>
                    <Footer/>
            </AuthProvider>
        </div>
    );
}
