import { useState } from "react";

function PaginationBox({max}) {
  const [page, setPage] = useState(1);

  // up 함수
  const up = () => {
    if(page < max) {
      setPage(prev => prev + 1);
    }
    else {
      setPage(1);
    }
  }

  // down 함수
  const down = () => {
    if(page > 1) {
      setPage(prev => prev - 1);
    }
    else {
      setPage(max);
    }
  }

  // up + down 함수
  const move = (num) => {
    if(num > 0) {
      if(page < max) {
        setPage(prev => prev + 1);
      }
      else {
        setPage(1);
      }
    }
    if(num < 0) {
      if(page > 1) {
        setPage(prev => prev - 1);
      }
      else {
        setPage(max);
      }
    }
  }

  return (
    <>
      <div>
        <button onClick={() => move(-1)}>&lt;</button>
        <span>{page} / {max}</span>
        <button onClick={() => move(1)}>&gt;</button>
      </div>
    </>
  );
}

export default PaginationBox;