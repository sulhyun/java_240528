/*
PaginationBox 컴포넌트를 생성해서 2개 만들어 활용
버튼 1/4 버튼
버튼 1/13 버튼
	- 재사용을 위해 props를 활용할 수 있는지 확인하는 예제
*/

import PaginationBox from "./PaginationBox";

function ButtonEx4() {
  return (
    <>
      <PaginationBox max={4} />
      <PaginationBox max={13} />
    </>
  )
}

export default ButtonEx4;