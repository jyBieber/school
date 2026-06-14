const base = {
    get() {
        return {
            url : "http://localhost:8080/campuserrands/",
            name: "campuserrands",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/campuserrands/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园跑腿管理系统"
        } 
    }
}
export default base
