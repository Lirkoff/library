import React from "react";

export const LoginForm = () => {
    return (
        <div className="tab-content text-white">
            <div className="tab-pane show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                <form>
                    <div className="text-center mb-3">
                        <p className={'mt-3'}>Sign in with:</p>
                        <button type="button"
                                className="btn text-white btn-floating mx-1">
                            <i className="fab fa-facebook-f"></i>
                        </button>

                        <button type="button"
                                className="btn text-white btn-floating mx-1">
                            <i className="fab fa-google"></i>
                        </button>

                        <button type="button"
                                className="btn text-white btn-floating mx-1">
                            <i className="fab fa-twitter"></i>
                        </button>

                        <button type="button"
                                className="btn text-white btn-floating mx-1">
                            <i className="fab fa-github"></i>
                        </button>
                    </div>

                    <p className="text-center">or:</p>


                    <div className="form-outline mb-4">
                        <input type="email" id="loginName" className="form-control" />
                        <label className="form-label" htmlFor="loginName">Email or username</label>
                    </div>


                    <div className="form-outline mb-4">
                        <input type="password" id="loginPassword" className="form-control"/>
                        <label className="form-label" htmlFor="loginPassword">Password</label>
                    </div>


                    <div className="row mb-4">
                        <div className="col-md-6 d-flex justify-content-center">

                            <div className="form-check mb-3 mb-md-0">
                                <input className="form-check-input" type="checkbox" value="" id="loginCheck"/>
                                <label className="form-check-label" htmlFor="loginCheck"> Remember me </label>
                            </div>
                        </div>

                        <div className="col-md-6 d-flex justify-content-center">
                            <a className={'text-white'} href="#!">Forgot password?</a>
                        </div>
                    </div>


                    <button type="submit"
                            className="btn btn-block text-white border-2 border-white mb-4">Sign in
                    </button>


                    <div className="text-center">
                        <p>Not a member? <a className={'text-white'} href="#!">Register</a></p>
                    </div>
                </form>
            </div>
        </div>
    )
}