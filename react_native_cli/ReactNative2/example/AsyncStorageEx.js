import React from "react";
import AsyncStorage from "@react-native-async-storage/async-storage";

function AsyncStorageEx() {
  // 저장하기
  const save = async() => {
    try {
      // 문자열 타입 저장
      await AsyncStorage.setItem('key', 'value');

      // 객체 및 배열 타입 저장
      await AsyncStorage.setItem('todos', JSON.stringify(todos));
    } catch(e) {
      // 오류 예외 처리
    }
  }

  // 불러오기
  const load = async() => {
    try {
      // 문자열 타입 불러오기
      const value = await AsyncStorage.getItem('key');

      // 객체 및 배열 타입 불러오기
      const rawTodos = await AsyncStorage.getItem('todos');
      const todos = JSON.parse(rawTodos);
    } catch(e) {
      // 오류 예외 처리
    }
  }

  // 초기화 하기
  const clearAll = async() => {
    try {
      await AsyncStorage.clear();
    } catch(e) {
      // 오류 예외 처리
    }
  }
}

export default AsyncStorageEx;