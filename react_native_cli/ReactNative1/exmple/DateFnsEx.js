import React from 'react';
// format: 다양한 형태로 날짜를 포맷팅함
// formatDistanceToNow: 현재 시각을 기준으로 단어를 사용해 시간을 나타냄 (예: 5분전) 
import { format, formatDistanceToNow } from 'date-fns';
// ko: 한국어 설정
import { ko } from 'date-fns/locale';

function DateFnsEx() {
  function DateFormat() {
    const d = new Date();                     // 비교할 객체
    const now = Date.now();                   // 현재 시점의 타임 스탬프(밀리초 단위)
    const diff = (now - d.getTime()) / 1000;  // 현재와 대상 시간의 차이를 초 단위로 계산
  
    // 시간 차이가 1분(60초) 미만일 경우
    if(diff < 60 * 1) {
      return '방금 전';
    }
    // 시간 차이가 3일 미만일 경우 
    // addSuffix: '전/후' 접미사를 붙임
    // locale: ko는 결과값을 한국어로 변환
    if(diff < 60 * 60 * 24 * 3) {
      return formatDistanceToNow(d, {addSuffix: true, locale: ko});
    }
    // 시간 차이 3일 이상일 경우
    // PPP : 지역별 날짜 형식 (예: 2026년 2월 2일)
    // EEE : 요일 (예: 목)
    // p : 지역별 시간 형식 (예: 오후 11:10)
    return format(d, 'PPP EEE p', {locale: ko});
  }
  DateFormat();
}
export default DateFnsEx;