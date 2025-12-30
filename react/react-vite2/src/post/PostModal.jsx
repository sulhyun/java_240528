import { useState } from "react";

function PostModal({ list, setList, post, setPost, closeModal }) {
  const [flag, setFlag] = useState(false);

  const del = (id) => {
    setList(list.filter((item) => {
      return(item.id !== id);
    }));
    closeModal();
  }

  const onChangeHandler = (e) => {
    const {name, value} = e.target;
    setPost({...post, [name] : value});
  }

  const save = () => {
    const tmpList = list.map((item) => {
      return(item.id === post.id ? post : item);
    });
    setList(tmpList);
    setFlag(false);
  }
  return(
    <>
      <div id="modal">
        <div id="modal-content">
          <div>
            <label>번호</label>
            <input type="text" className="num" value={post.id} readOnly />
				  </div>
			  	<div>
				  	<label>제목</label>
            <input type="text" name="title" className="title" value={post.title} onChange={onChangeHandler} readOnly={!flag} />
			  	</div>
				  <div>
					  <label>작성자</label>
            <input type="text" name="writer" className="writer" value={post.writer} onChange={onChangeHandler} readOnly={!flag} />
				  </div>
				  <div>
					  <label>조회수</label>
            <input type="text" className="view" value={post.view} readOnly />
			  	</div>
				  <div>
					  <label>내용</label>
            <textarea className="content" name="content" rows="10" value={post.content} onChange={onChangeHandler} readOnly={!flag}></textarea>
				  </div>
          <div>
				    <button onClick={closeModal}>닫기</button>
          </div>
          {flag ? <button onClick={save}>저장</button> : <button onClick={() => setFlag(true)}>수정</button>}
          <button onClick={() => del(post.id)}>삭제</button>
        </div>
      </div>
    </>
  )
}

export default PostModal;