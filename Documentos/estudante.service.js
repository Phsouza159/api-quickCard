
import * as httpService from './httpService';

(function(){
   
    let estudanteService = {}

    let __CORRENT_URL_API = 'http://127.0.0.1:8080'
    let __PATH = '/estudante'

    estudanteService._url = `${__CORRENT_URL_API}${__PATH}`

    estudanteService.login = async (user , senha) => {
        let userToken = await httpService.onPost(`${__CORRENT_URL_API}/authenticate`, { username: user, password: senha })

        if(userToken){
            localStorage.setItem('token' , userToken.jwttoken)
            localStorage.setItem('user' , userToken)
        
            return true
        }

        return false
    }

    estudanteService.getEstudante = async (id) => {
        
        httpService.onPost(estudanteService._url , {  })
    }
    
    window.estudanteService = estudanteService
    //module.exports = { estudanteService }
})();