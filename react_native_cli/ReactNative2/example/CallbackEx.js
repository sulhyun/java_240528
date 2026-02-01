import React from "react";

function CallbackExample() {
  // 콜백 함수
  function double(number, callback) {
    setTimeout(() => {
      if(!callback) {
        return;
      }
      let result = number * 2;
      console.log(`${number} X 2 = ${result}`);
      callback(result);
    }, 0);
  }

  function hello() {
    console.log('hello');
  }

  double(1, result => {
    double(result, result => {
      double(result, result => {
        double(result, result => {
          console.log(`최종 결과: ${result}`);
        })
      })
    })
  })
  hello();
}

export default CallbackExample;