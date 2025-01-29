import api from "./api";

const providerApi = (() => {

    const getAllProviders = () => {
        return api.get('/providers');
    }

    const getProvidersForMedia = (id) => {
        return api.get(`/providers/${id}`);
    }

    return{
        getAllProviders,
        getProvidersForMedia
    }
})();

export default providerApi;