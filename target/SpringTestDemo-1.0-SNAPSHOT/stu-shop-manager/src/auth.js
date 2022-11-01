import qs from "qs";

export function getReady() {
    let user = qs.parse(window.localStorage.getItem("user"));
    let loca=window.location.origin
    // console.log(window.location)
    console.log(user)
    if (!user.menus||user.menus.length==0) {
        return false
    }

    const b=loop(loca,user.menus);
    console.log(b)
    return b;
    // for (let i = 0; i < user.menus.length; i++) {
    //     if(loca+user.menus[i].url==window.location.href){
    //
    //         return true
    //     }
    //
    // }
    // return false

}

//利用递归循环查询子菜单和父级菜单都要比对
function loop(loca,menus) {

    if (!menus||menus.length<1) {
        return false;
    }
    for (let i = 0; i < menus.length; i++) {
        if(loca+menus[i].url==window.location.href){
            return true;
        }

        if (menus[i].child){
            if(loop(loca,menus[i].child)){
                return true;
            }
        }

    }
    return false
}