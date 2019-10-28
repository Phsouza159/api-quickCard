
import * as httpService from './httpService';

export default class EstudanteService {

    static pathBlocoCartao ='blocoCartaoMemoria'
    static pathAuthenticate ='authenticate'

    static _host = 'http://186.213.213.162:8080'
    static _path = '/estudante'
    static _url = `${_host}${_path}`

    isAuthenticate = () => {
        let user = localStorage.getItem('user');

        if(user != null) {
            return true;
        }

        return false;
    }

    //#region ESTUDANTE

    /**
     * @param user usuario email
     * @param senha senha do usuario
     * @example login( 'user' , 'senha')
     */
    login = async (user, senha) => {
        let userToken = await httpService.onPost(`${EstudanteService._host}/${EstudanteService.pathAuthenticate}`, { username: user, password: senha })

        if (userToken) {
            localStorage.setItem('token', userToken.jwttoken)
            localStorage.setItem('user', JSON.stringify(userToken))

            return true
        }

        return false
    }

    /**
     * @param idEstudante id do estudante
     * @example getEstudante( 'de447979-f394-466e-bb43-8c1dc1f13650')
     * @returns Estudante entity
     */
    getEstudante = async (id) => {

        return httpService.onGet(`${EstudanteService._url}/${id}`)
    }

    /**
     * @param idEstudante id do estudante
     * @example estudanteModel : {
 	 *   "email" : "string",
	 *   "nome" : "string",
	 *   "senha": "string"
     * }
     */
    estudanteCreated = async (estudanteModel) => {

        return httpService.onGet(`${EstudanteService._url}/${id}`)
    }

    //#endregion

    //#region BLOCO CARTAO

    /**
     * @param idEstudante id do estudante
     * @returns Coleção de blocos de cartoes entity
     * @example getAllBlocoCartao( 'de447979-f394-466e-bb43-8c1dc1f13650')
     */
    getAllBlocoCartao = async (idEstudante) => {

        return httpService.onGet(`${EstudanteService._host}/${EstudanteService.pathBlocoCartao}/${idEstudante}`)
    }

    /**
     * @param idEstudante id do estudante 
     * @param idBlocoCartao id do bloco-cartao
     * @returns Bloco-cartap referente ao id passado na requisição entity
     * @example getBlocoCartaoById( 'de447979-f394-466e-bb43-8c1dc1f13650' , '8f506718-39f2-4a7a-8ac6-569149e79c51')
     */
    getBlocoCartaoById = async (idEstudante, idBlocoCartao) => {

        return httpService.onGet(`${EstudanteService._host}/${EstudanteService.pathBlocoCartao}/${idEstudante}/${idBlocoCartao}`)
    }

    /**
      * @param idEstudante id do estudante
      * @param idBlocoCartao id do bloco-cartao
      * @param blocoCartaoModel objeto model para criacao de um bloco-cartao
      * @example blocoCartaoModel : {
      * 	    "nomeBloco" : "string"
      * }
      */
    blocoCartaoUpdate = async (idEstudante, idBlocoCartao , blocoCartaoModel) => {

        httpService.onPost(`${EstudanteService._host}/${EstudanteService.pathBlocoCartao}/${idEstudante}/${idBlocoCartao}`, blocoCartaoModel)
    }

    /**
     * @param idEstudante id do estudante 
     * @param idBlocoCartao id do bloco-cartao
     * @example getBlocoCartaoDelete( 'de447979-f394-466e-bb43-8c1dc1f13650' , '8f506718-39f2-4a7a-8ac6-569149e79c51')
     */
    getBlocoCartaoDelete = async (idEstudante, idBlocoCartao) => {

        return httpService.onDelete(`${EstudanteService._host}/${EstudanteService.pathBlocoCartao}/${idEstudante}/${idBlocoCartao}`)
    }
    //#endregion
}
