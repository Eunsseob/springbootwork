import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import axios from 'axios';
import { useEffect } from 'react';

function App() {
	const [hello, setHello] = useState(' ');
	const [menuList, setMenuList] = useState([]);
	
	useEffect(() => {
		axios.get('/api/test')
				.then(result => {
					console.log(result);
					setHello(result.data);
				})
				.catch(() => {
					console.log("실패");
				})
	})
  return (
    <div className="App">
      <h3>서버에서 들어온 값 : {hello}</h3>
	  <hr />
	  {
	  menuList.map(menu => {
	  	return (
	  		<div>{menu.name}</div>
	  	)
		  })
	  }
	  <button onClick={() => {
		axios.get('/api/menuall')
				.then(result => {
					console.log(result);
					setMenuList(result.data);
				})
	  }}> 서버에서 메뉴 가져오기 </button>
	  <br></br><br></br>
	  <button onClick={() => {
		axios.post('/api/addmenu', {restaurant: '비욘더 강남', 
																	name : '딜허브',
																	price : 22000,
																	type : 'KR',
																	taste : 'MILD' 
		})
		.then(result => {
			console.log(result);
		})
	  }}>메뉴 추가 </button>
    </div>
  );
}

export default App;
