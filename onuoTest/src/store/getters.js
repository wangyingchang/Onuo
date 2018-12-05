const getters = {
  sidebar: state => state.app.sidebar,

  token: state => state.user.token,
  userId: state => state.user.userId,
  email: state => state.user.email,
  username: state => state.user.username,
  avatar: state => state.user.avatar,
  lastLoginTime: state => state.user.lastLoginTime,
  registerTime: state => state.user.registerTime,
  resume: state => state.user.resume,
  roleName: state => state.user.roleName,
  policeId: state => state.user.policeId,
  permissionCodeList: state => state.user.permissionCodeList,

  permissionRouters: state => state.permission.routers,
  addRouters: state => state.permission.addRouters
}
export default getters
