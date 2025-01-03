import axios from "axios";


const API_URL = `${process.env.REACT_APP_API}/auth`; // Change to your backend URL

export const registerUser = async (data: {
    username: string;
    email: string;
    password: string;
    repeatPassword: string; }) => {
    return axios.post(`${API_URL}/register`, data);
};

export const loginUser = async (data: { username: string; password: string }) => {
    return axios.post(`${API_URL}/login`, data);
};
