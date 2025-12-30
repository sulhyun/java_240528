import { useState } from "react";

function PostInsert({ list, setList }) {
  const [title, setTitle] = useState("");
  const [writer, setWriter] = useState("");
  const [content, setContent] = useState("");
  const [id, setId] = useState(1);

  const onChangeTitle = (e) => {
    setTitle(e.target.value);
  }

  const onChangeWriter = (e) => {
    setWriter(e.target.value);
  }

  const onChangeContent = (e) => {
    setContent(e.target.value);
  }

  const add = () => {
    if(title.trim() === "" || writer.trim() === "" || content.trim() === "") {
      return;
    }
    const tmp = {
      id : id,
      title : title,
      writer : writer,
      content : content,
      view : 0
    }
    setList([...list, tmp]);
    setId((prev) => prev + 1);
    setTitle("");
    setWriter("");
    setContent("");
  }
  return(
    <>
      <div>
        <label htmlFor="title">제목</label>
        <input type="text" id="title" className="title" onChange={onChangeTitle} value={title} />
        <label htmlFor="writer">작성자</label>
        <input type="text" id="writer" className="writer" onChange={onChangeWriter} value={writer} />
        <label htmlFor="content">내용</label>
        <textarea id="content" className="content" rows="10" onChange={onChangeContent} value={content}></textarea>
        <button onClick={add}>게시글 등록</button>
      </div>
    </>
  )
}

export default PostInsert;