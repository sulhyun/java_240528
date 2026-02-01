import React from "react";

function AsynchronousExample() {
  // 비동기적 작업
  function double(number) {
    console.log('START');
    setTimeout(() => {
      let result = number * 2;
      console.log(`${number} X 2 = ${result}`);
      console.log('END');
    }, 0);
  }

  function hello() {
    console.log('hello');
  }

  double(2);
  hello();
}

export default AsynchronousExample;
