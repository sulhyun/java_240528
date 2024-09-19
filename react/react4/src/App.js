import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import Signup from './Signup';

function App() {
  return (
    <Container>
      <h1>테스트</h1>
      {/* 
        1. 회원 가입 화면을 구성  
        2. 회원가입 버튼을 클릭 -> 스프링으로 회원 정보 전송 
        3. 전송된 회원 정보를 이용해서 회원 가입하는 기능 구현
        --------------------------------------------------
        spring3 프로젝트에 작업
        TestController를 추가해서 작업
      */}
      <Signup />
     
    </Container>
  );
}

export default App;
