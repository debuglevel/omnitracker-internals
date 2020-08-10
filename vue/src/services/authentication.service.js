export const authenticationService = {
  login,
  logout,
//   authHeader,
  authConfig
};

function login(username, password) {
    var auth = {};
    // btoa() is insane's programming language for toBase64()
    //auth.authdata = window.btoa(username + ":" + password);
    auth.username = username;
    auth.password = password;
    localStorage.setItem("auth", JSON.stringify(auth));
}

function logout() {
    localStorage.removeItem("auth");
}

// function authHeader() {
//     // return authorization header with basic auth credentials
//     let auth = JSON.parse(localStorage.getItem('auth'));

//     if (auth && auth.authdata) {
//         return { 'Authorization': 'Basic ' + user.authdata };
//     } else {
//         return {};
//     }
// }

function authConfig() {
    // return authorization header with basic auth credentials
    let auth = JSON.parse(localStorage.getItem('auth'));

    return { auth: auth };

    // if (auth && auth.authdata) {
    //     return { 'Authorization': 'Basic ' + user.authdata };
    // } else {
    //     return {};
    // }
}