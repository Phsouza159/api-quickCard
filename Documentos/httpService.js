let tratarErroRequest = (err) => {
   
    console.warn(err)
    return err
}

let getAuthorization = (headerAuthorization) => {
    let token = localStorage.getItem('token')

    return headerAuthorization.replace('null' , token).replace('_TOKEN_' , token)
}

let onPost = async function(url , body = {}){
    return fetch(url , {
            headers: {
                'Authorization': getAuthorization('Bear _TOKEN_'), 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body : JSON.stringify(body)
        })
        .then( result => result.json())
        .catch( err => tratarErroRequest(err))
}

let onGet = async function(url){
    return fetch(url , {
            headers: {
                'Authorization': getAuthorization('Bearer _TOKEN_'), 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'GET',
        })
        .then( result => result.json())
        .catch( err => tratarErroRequest(err))
}

let onPut = async function(url , body = {}){
    return fetch(url , {
            headers: {
                'Authorization': getAuthorization('Bearer _TOKEN_'), 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'PUT',
            body : JSON.stringify(body)
        })
        .then( result => result.json())
        .catch( err => tratarErroRequest(err))
}

let onDelete = async function(url , body = {}){
    return fetch(url , {
            headers: {
                'Authorization': getAuthorization('Bearer _TOKEN_'), 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'DELETE',
            body : JSON.stringify(body)
        })
        .then( result => result.json())
        .catch( err => tratarErroRequest(err))
}



window.httpService = { onPost , onGet , onPut , onDelete }

module.exports = { onPost , onGet , onPut , onDelete }