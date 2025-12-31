import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/spring': {
        target: 'http://localhost:8080/spring_react',
        changeOrigin: true,
        // rewrite 설정은 필요에 따라 추가
      }
    }
  }
})
