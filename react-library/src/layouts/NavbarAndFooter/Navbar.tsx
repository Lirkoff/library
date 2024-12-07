import React, {useEffect} from "react";
import {Link, NavLink} from "react-router-dom";
import {useAuth} from "../../auth/context/AuthContext";


export const Navbar: React.FC = () => {
    const {user, logout} = useAuth();

    const isAdmin = user?.roles?.includes("ROLE_ADMIN");
    const isModerator = user?.roles?.includes("ROLE_MODERATOR");



    return (
        <nav className='navbar navbar-expand-lg navbar-dark main-color py-3'>
            <div className='container-fluid'>
                <span className='navbar-brand'>Library</span>
                <button className='navbar-toggler' type='button'
                        data-bs-toggle='collapse' data-bs-target='#navbarNavDropdown'
                        aria-controls='navbarNavDropdown' aria-expanded='false' aria-label='Toggle navigation'>
                    <span className='navbar-toggler-icon'></span>
                </button>
                <div className='collapse navbar-collapse' id='navbarNavDropdown'>
                    <ul className='navbar-nav'>
                        <li className='nav-item'>
                            <NavLink className='nav-link' to='/home'>Home</NavLink>
                        </li>
                        <li className='nav-item'>
                            <NavLink className='nav-link' to='/search'>Search books</NavLink>
                        </li>
                        {user &&
                            <li className='nav-item'>
                                <NavLink to={'/shelf'} className='nav-link'>Shelf</NavLink>
                            </li>
                        }
                        {user &&
                            <li className='nav-item'>
                                <NavLink to={'/fees'} className='nav-link'>Pay fees</NavLink>
                            </li>
                        }
                        {user && isModerator &&
                            <li className='nav-item'>
                                <NavLink to={'/admin'} className='nav-link'>Admin</NavLink>
                            </li>
                        }
                    </ul>
                    {user ? (
                        <>
                            <ul className='navbar-nav ms-auto'>
                                <span className='nav-link text-white'>Welcome, {user.username}</span>
                                
                                <li className='navbar-nav ms-auto'>
                                    <button className='btn btn-outline-light' onClick={logout}>Logout</button>
                                </li>
                            </ul>
                        </>
                    ) : (
                        <ul className='navbar-nav ms-auto'>
                            <NavLink className='btn btn-outline-light' to={'/register'}>Sign Up</NavLink>
                        </ul>
                    )}
                </div>
            </div>
        </nav>
    )
}