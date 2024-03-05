/**
 * 비동기 통신을 지원하는 자바스크립트의 XHR 사용하기(Post)
 */

const clear = function(){
	document.querySelector('pcode').value=''
	document.querySelector('category').value=''
	document.querySelector('pname').value=''
	document.querySelector('price').value=''
}

//입력값을 가져와서 js 객체 -> json 문자열로 변환하여 서버에 전송하기
const save = function(){
	//비동기 통신에 필요한 데이터 json문자열 만들기
	const yn = confirm(`상품 등록하시겠습니까?`)
	if(!yn) return		//confirm 에서 취소누르면 false -> 함수 종료
	
	//1. 입력값 가져오기
	const pcode = document.querySelector('#pcode').value
	const category = document.querySelector('#category').value
	const pname = document.querySelector('#pname').value
	const price = document.querySelector('#price').value
	
	//2. 입력값으로 자바스크립트 객체 생성(자바스크립트 객체는 미리 타입을 정의하지 않고 사용할 수 있습니다.)
	const jsObj={pcode:pcode,
		category:category,
		pname:pname,
		price:price }
	console.log('자바스크립트 객체 : ',jsObj)	
	
	//3.자바스크립트 객체를 json 전송을 위해 직렬화(문자열로 변환)
	const jsonData = JSON.stringify(jsObj)
	console.log('jsOBj 문자열 : ',jsonData)
	
	//post 요청
	 const xhr = new XMLHttpRequest()               // 비동기 통신 객체 생성
	   xhr.open('POST','api/product')					// 전송 보낼 준비 (url과 method)
	   xhr.setRequestHeader("Content-Type","application/json;charset=UTF-8");
	   xhr.send(jsonData)                                 // 요청 전송.POST는 페이로드가 있습니다.
	   xhr.onload = function(){     // 요청에 대한 응답 받았을 때 onload 이벤트 생깁니다. onload 핸들러 함수
	      	if(xhr.status === 200 || xhr.status === 201) {   // readyState가 DONE
	         console.log("post 응답 : ", xhr.response)	
	         	//response 는 응답받은 내용을 저장한 프로퍼티
			}else{
				 console.error('오류1', xhr.response)
		         console.error('오류2', xhr.status)
			}
	}
}
document.querySelector('#new').addEventListener('click',function(){
	modal.show();
})

document.querySelector('#post').addEventListener('click',save)
document.querySelector('#clear').addEventListener('click',clear)