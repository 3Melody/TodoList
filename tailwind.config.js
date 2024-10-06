module.exports = {
  content: [
    './src/**/*.{html,ts,scss}',  // กำหนดเส้นทางของไฟล์ที่ใช้ Tailwind
  ],
  theme: {
    
    extend: {},
  },
  plugins: [
    require('daisyui'),  // เพิ่ม DaisyUI ลงใน plugins
  ],
}
