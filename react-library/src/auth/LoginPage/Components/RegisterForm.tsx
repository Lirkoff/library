import React, {useState} from "react";
import {registerUser} from "../../../api/Api";
import {useHistory} from "react-router-dom";

export const RegisterForm = () => {
    const history = useHistory();
    const [formData, setFormData] = useState({ username: "", email: "", password: "", repeatPassword: "" });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await registerUser(formData);
            alert("Registration successful! You can now login.");
            history.push("/login");
        } catch (error) {
            console.error("Registration failed", error);
        }
    };

    return (
        <div className="tab-pane text-white" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
            <form onSubmit={handleSubmit}>
                <div className="text-center mb-3">
                    <p className={'mt-3'}>Sign up with:</p>
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

                <p className="text-center text-white">or:</p>


                <div className="form-outline mb-4">
                    <input type="text" id="regUsername" name="username" onChange={handleChange} className="form-control"/>
                    <label className="form-label text-white" htmlFor="username">Username</label>
                </div>



                <div className="form-outline mb-4">
                    <input type="email" id="email" name="email" onChange={handleChange} className="form-control"/>
                    <label className="form-label text-white" htmlFor="email">Email</label>
                </div>


                <div className="form-outline mb-4">
                    <input type="password" id="regPassword" name="password" onChange={handleChange} className="form-control"/>
                    <label className="form-label text-white" htmlFor="password">Password</label>
                </div>


                <div className="form-outline mb-4">
                    <input type="password" id="repeatPassword" name="repeatPassword" onChange={handleChange} className="form-control"/>
                    <label className="form-label text-white" htmlFor="repeatPassword">Repeat password</label>
                </div>


                <div className="form-check d-flex justify-content-center mb-4">
                    <input className="form-check-input me-2" type="checkbox" value="" id="registerCheck"
                           aria-describedby="registerCheckHelpText"/>
                    <label className="form-check-label" htmlFor="registerCheck">
                        I have read and agree to the terms
                    </label>
                </div>

                <button type="submit"
                        className="btn text-white btn-block border-2 border-white mb-3">Sign up
                </button>
            </form>
        </div>
    )
}