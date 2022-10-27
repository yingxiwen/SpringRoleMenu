import qs from "qs";

export function getReady() {
    let user = qs.parse(window.localStorage.getItem("user"));
    let loca=window.location.origin
    console.log(window.location)
    if (!user.menus) {
        return false
    }
    for (let i = 0; i < user.menus.length; i++) {
        if(loca+user.menus[i].url==window.location.href){

            return true
        }

    }
    return false
}