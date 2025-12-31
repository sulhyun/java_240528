import { Link } from 'react-router-dom';

function Nav() {

  return(
    <>
      <nav>
        <li>
          <Link to={"/"}>홈으로</Link>
        </li>
        <li>
          <Link to={"/post/list/0"}>커뮤니티</Link>
        </li>
      </nav>
    </>
  )
}

export default Nav;