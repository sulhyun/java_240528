import React from "react";

function SynchronousExample() {
  // 동기적 작업
  function double(number) {
    console.log('START');
    let result = number * 2;
    console.log(`${number} X 2 = ${result}`);
    console.log('END');
  }

  function hello() {
    console.log('hello');
  }

  double(2);
  hello();
}

export default SynchronousExample;
