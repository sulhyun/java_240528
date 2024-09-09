// css 폴더에 App.css가 있고, 연결할 때 사용
// import './css/App.css'

import Button from "./Button";

// 최상위 태그는 한개만 존재해야 됨
function App() {
 
  return (
    <div>
      <button>버튼</button>
      <Button />
    </div>
  );
}

export default App;
