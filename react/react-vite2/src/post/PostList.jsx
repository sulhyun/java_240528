import PostModal from "./PostModal";
import { useState } from "react";

function PostList({ list, setList }) {
  const [modal, setModal] = useState(false);
  const [post, setPost] = useState(null);

  const openModal = (post) => {
    const tmpList = list.map((item) => {
      return(post.id === item.id ? {...item, view : item.view + 1} : item);
    });
    setList(tmpList);
    const tmp = tmpList.find((item) => {
      return(item.id === post.id);
    }); // 모달에 증가된 조회수를 확인하기 위한 코드
    setPost(tmp);
    setModal(true);
  }

  const closeModal = () => {
    setModal(false);
  }
  return(
    <>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>내용</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item) => {
              return(
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td onClick={() => openModal(item)}>{item.title}</td>
                  <td>{item.writer}</td>
                  <td>{item.content}</td>
                  <td>{item.view}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      {modal ? <PostModal list={list} setList={setList} post={post} setPost={setPost} closeModal={closeModal} /> : ""}
    </>
  );
}

export default PostList;