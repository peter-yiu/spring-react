import axios from 'axios';

import { toast } from "sonner";

/*const instance = axios.create({
    baseURL:process.env.APP_API_URL,
    timeout:5000
})*/

axios.defaults.timeout = 100000;
axios.defaults.baseURL = `${process.env.NEXT_PUBLIC_BACKEND_BASE_URI}/api`;

//添加拦截
axios.interceptors.request.use(config => {
    // console.log('请求被拦截')
    return config
},error => {
    // console.warn('Error! Request Error reach the API. ' + error);
    toast.error('Error! Request Error reach the API. ' + error);
    return Promise.reject(error);
})

axios.interceptors.response.use(res => {

    // 根据后端约定，response.data形式为{success:boolean, msg:string, data:object,code:string}
    if (res.data.success) {
        return res.data
    } else {

        /*Message.error({
            showClose: true,
            message: response.data.msg,
            duration:10000
        });*/
        toast.error(res.data.msg);
        return Promise.reject(res.data.msg)
    }
},error => {

    // console.warn('Error! Could not reach the API. ' + error);
    toast.error("Error! Could not reach the API.");
    return Promise.reject(error);
})


export default axios;
