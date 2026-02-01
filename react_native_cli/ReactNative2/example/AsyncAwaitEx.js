import React from "react";

function AsyncAwaitEx() {
  function double(number) {
    const promise = new Promise((resolve, reject) => {
      setTimeout(() => {
        if(typeof number !== 'number') {
          reject(new Error('Parameter is not vaild'));
          return;
        }
        const result = number * 2;
        console.log(`${number} X 2 = ${result}`);
        resolve(result);
      })
    })
    return promise;
  }

  async function process() {
    let result = 1;
    result = await double(result);
    result = await double(result);
    result = await double(result);
    result = await double(result);
    return result;
  }

  process().then(
    result => {
      console.log(`최종 결과: ${result}`);
    }
  )
}

export default AsyncAwaitEx;