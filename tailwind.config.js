module.exports = {
  content: ['./src/main/resources/templates/**/*.html'],
  theme: {
    extend: {},
  },
  plugins: [
    require('@tailwindcss/forms')
  ],
};
