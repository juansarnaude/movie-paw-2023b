import api from "./api";

const genreApi = (() => {

    const getAllGenres = () => {
        return api.get('/genres');
    }

    const getGenresForMedia = (id) =>{
        return api.get(`/genres/${id}`);
    }

    return{
        getAllGenres,
        getGenresForMedia
    }
})();

export default genreApi;