
import * as httpService from './httpService';

(function () {

    let estudanteService = {}
    let pathBlocoCartao = 'blocoCartaoMemoria'


    estudanteService.__HOST = 'http://127.0.0.1:8080'
    estudanteService.__PATH = '/estudante'
    estudanteService._url = `${estudanteService.__HOST}${estudanteService.__PATH}`

    //#region ESTUDANTE

    /**
     * @param idEstudante id do estudante
     * @example login( 'user' , 'senha')
     */
    estudanteService.login = async (user, senha) => {
        let userToken = await httpService.onPost(`${estudanteService.__HOST}/authenticate`, { username: user, password: senha })

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
    estudanteService.getEstudante = async (id) => {

        return httpService.onGet(`${estudanteService._url}/${id}`)
    }

    /**
     * @param idEstudante id do estudante
     * @example estudanteModel : {
 	 *   "email" : "string",
	 *   "nome" : "string",
	 *   "senha": "string"
     * }
     */
    estudanteService.estudanteCreated = async (estudanteModel) => {

        return httpService.onGet(`${estudanteService._url}/${id}`)
    }

    //#endregion

    //#region BLOCO CARTAO

    /**
     * @param idEstudante id do estudante
     * @returns Coleção de blocos de cartoes entity
     * @example getAllBlocoCartao( 'de447979-f394-466e-bb43-8c1dc1f13650')
     */
    estudanteService.getAllBlocoCartao = async (idEstudante) => {

        return httpService.onGet(`${estudanteService.__HOST}/${pathBlocoCartao}/${idEstudante}`)
    }

    /**
     * @param idEstudante id do estudante 
     * @param idBlocoCartao id do bloco-cartao
     * @returns Bloco-cartap referente ao id passado na requisição entity
     * @example getBlocoCartaoById( 'de447979-f394-466e-bb43-8c1dc1f13650' , '8f506718-39f2-4a7a-8ac6-569149e79c51')
     */
    estudanteService.getBlocoCartaoById = async (idEstudante, idBlocoCartao) => {

        return httpService.onGet(`${estudanteService.__HOST}/${pathBlocoCartao}/${idEstudante}/${idBlocoCartao}`)
    }

    /**
      * @param idEstudante id do estudante
      * @param idBlocoCartao id do bloco-cartao
      * @param blocoCartaoModel objeto model para criacao de um bloco-cartao
      * @example blocoCartaoModel : {
      * 	    "nomeBloco" : "string"
      * }
      */
    estudanteService.blocoCartaoUpdate = async (idEstudante, idBlocoCartao , blocoCartaoModel) => {

        httpService.onPost(`${estudanteService.__HOST}/${idEstudante}/${idBlocoCartao}`, blocoCartaoModel)
    }

    /**
     * @param idEstudante id do estudante 
     * @param idBlocoCartao id do bloco-cartao
     * @example getBlocoCartaoDelete( 'de447979-f394-466e-bb43-8c1dc1f13650' , '8f506718-39f2-4a7a-8ac6-569149e79c51')
     */
    estudanteService.getBlocoCartaoDelete = async (idEstudante, idBlocoCartao) => {

        return httpService.onDelete(`${estudanteService.__HOST}/${pathBlocoCartao}/${idEstudante}/${idBlocoCartao}`)
    }
    //#endregion

    window.estudanteService = estudanteService
    //module.exports = { estudanteService }
})();