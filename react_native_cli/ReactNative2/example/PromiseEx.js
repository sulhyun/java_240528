import React from "react";

function PromiseExample() {
  // 프로미스
  function double(number) {
    const promise = new Promise((resolve, reject) => {
      setTimeout(() => {
        if (typeof number !== 'number') {
          reject(new Error('Parameter is not a valid'));
          return;
        }
        const result = number * 2;
        console.log(`${number} X 2 = ${result}`);
        resolve(result);
      }, 500);
    })
    return promise;
  }

  double(1)
    .then(result => double(result))
    .then(result => double(result))
    .then(result => double(result))
    .then(result => {
      console.log(`최종 결과: ${result}`);
    })
    .catch(
      e => {
        console.error(e);
      }
    )
  
  double(1)
  .then(double)
  .then(double)
  .then(double)
  .then(result => {
    console.log(`최종 결과: ${result}`);
  })
  .catch(
    e => {
      console.error(e);
    }
  )
}

export default PromiseExample;