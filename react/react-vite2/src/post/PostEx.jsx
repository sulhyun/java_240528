import "./PostEx.css";
import PostList from './PostList.jsx';
import PostInsert from './PostInsert.jsx';
import { useState } from "react";

function PostEx() {
  const [list, setList] = useState([{
    id : 0,
    title : '공지',
    writer : 'Admin',
    content : '공지사항',
    view : 0
  }]);
  return(
    <>
      <h1>커뮤니티</h1>
      <PostList list={list} setList={setList} />
      <PostInsert list={list} setList={setList} />
    </>
  );
}

export default PostEx;