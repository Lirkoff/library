import React, { useState } from "react";
import { registerUser } from "../../../api/Api";
import { useHistory } from "react-router-dom";

interface FormData {
    username: string;
    email: string;
    password: string;
    repeatPassword: string;
}

interface FormErrors {
    username?: string;
    email?: string;
    password?: string;
    repeatPassword?: string;
}

export const RegisterForm = () => {
    const history = useHistory();

    const [formData, setFormData] = useState<FormData>({
        username: "",
        email: "",
        password: "",
        repeatPassword: ""
    });

    const [errors, setErrors] = useState<FormErrors>({});

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const emailRegex = /\S+@\S+\.\S+/;

    const validateForm = () => {
        const newErrors: FormErrors = {};

        if (!formData.username.trim()) {
            newErrors.username = "Username is required.";
        }

        if (!formData.email.trim()) {
            newErrors.email = "Email is required.";
        } else if (!emailRegex.test(formData.email)) {
            newErrors.email = "Invalid email format.";
        }

        if (!formData.password.trim() || formData.password.length < 6 || formData.password.length > 20) {
            newErrors.password = "Password must be between 6 and 20 characters long.";
        }

        if (formData.password !== formData.repeatPassword) {
            newErrors.repeatPassword = "Passwords do not match.";
        }

        setErrors(newErrors);

        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        const isValid = validateForm();
        if (!isValid) {
            return;
        }

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
                    <p className="mt-3">Sign up with:</p>
                    <button type="button" className="btn text-white btn-floating mx-1">
                        <i className="fab fa-facebook-f"></i>
                    </button>
                    <button type="button" className="btn text-white btn-floating mx-1">
                        <i className="fab fa-google"></i>
                    </button>
                    <button type="button" className="btn text-white btn-floating mx-1">
                        <i className="fab fa-twitter"></i>
                    </button>
                    <button type="button" className="btn text-white btn-floating mx-1">
                        <i className="fab fa-github"></i>
                    </button>
                </div>

                <p className="text-center text-white">or:</p>

                {/* Username Field */}
                <div className="form-outline mb-4">
                    <input
                        type="text"
                        id="regUsername"
                        name="username"
                        onChange={handleChange}
                        className="form-control"
                    />
                    <label className="form-label text-white" htmlFor="username">
                        Username
                    </label>
                    {errors.username && <div className="text-danger">{errors.username}</div>}
                </div>

                {/* Email Field */}
                <div className="form-outline mb-4">
                    <input
                        type="email"
                        id="email"
                        name="email"
                        onChange={handleChange}
                        className="form-control"
                    />
                    <label className="form-label text-white" htmlFor="email">
                        Email
                    </label>
                    {errors.email && <div className="text-danger">{errors.email}</div>}
                </div>

                {/* Password Field */}
                <div className="form-outline mb-4">
                    <input
                        type="password"
                        id="regPassword"
                        name="password"
                        onChange={handleChange}
                        className="form-control"
                    />
                    <label className="form-label text-white" htmlFor="password">
                        Password
                    </label>
                    {errors.password && <div className="text-danger">{errors.password}</div>}
                </div>

                <div className="form-outline mb-4">
                    <input
                        type="password"
                        id="repeatPassword"
                        name="repeatPassword"
                        onChange={handleChange}
                        className="form-control"
                    />
                    <label className="form-label text-white" htmlFor="repeatPassword">
                        Repeat password
                    </label>
                    {errors.repeatPassword && (
                        <div className="text-danger">{errors.repeatPassword}</div>
                    )}
                </div>

                <button type="submit" className="btn text-white btn-block border-2 border-white mb-3">
                    Sign up
                </button>
            </form>
        </div>
    );
};
