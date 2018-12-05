import Cookies from 'js-cookie'


const TokenKey = 'User-Token'
// 有效期 1 天
const expires = 1

export function getToken() {
  // console.log(Cookies.get(TokenKey))
  return Cookies.get(TokenKey)
  // return "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLHJvbGU6YWRkLHJvbGU6ZGVsZXRlLHJvbGU6bGlzdCxyb2xlOnVwZGF0ZSx1c2VyOmFkZCx1c2VyOmRlbGV0ZSx1c2VyOmxpc3QsdXNlcjp1cGRhdGUiLCJleHAiOjE1MzI5OTk4MjN9.xrYnZF7RYdxmm8OLHonqnrpkDuZZWIal6INPeh41nnDO1w_O3xNVWWS6xZN5JeCz1o5oTCltVT2TjGD7B5UlEw"
 }
export function setToken(token) {
  return Cookies.set(TokenKey, token, { expires: expires })
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}
