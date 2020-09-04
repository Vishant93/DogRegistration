import axios from 'axios';

const DOG_API_BASE_URL = 'http://localhost:8080/api/v1/dogs';
class DogService {
    getDogs() {
        return axios.get(DOG_API_BASE_URL);
    }
}

export default new DogService()