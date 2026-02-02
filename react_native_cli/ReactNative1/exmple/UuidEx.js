import React from 'react';
// UUID는 범용 고유 식별자
// 일반적으로 랜덤하고 고유한 식별자를 생성할 때는 v4 사용
import { v4 as uuidv4 } from 'uuid';

/*
  이 라이브러리는 Node.js의 crypto 기능을 사용하는데
  리액트 네이티브에는 이 기능이 기본적으로 내장되어 있지 않음
  따라서 정상 작동을 위해 2번의 라이브러리를 설치해야 됨
  1. npm install uuid
  2. npm install react-native-get-random-values
  3. index.js 최상단에 import 'react-native-get-random-values'
*/

function UuidEx() {
  console.lof(uuidv4());
}

export default UuidEx;