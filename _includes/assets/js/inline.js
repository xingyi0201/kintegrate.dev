const themeKey = '@@_THEME'
const defaultTheme = 'dark'

function getTheme() {
  const theme = localStorage.getItem(themeKey)
  if (!theme) {
    localStorage.setItem(themeKey, defaultTheme)
    return defaultTheme
  }
  return theme
}

function isDarkTheme() {
  return document.body.classList.contains('dark')
}

function setTheme() {
  const theme = getTheme()

  if (theme === 'light' && isDarkTheme()) {
    document.body.classList.remove('dark')
  }
  if (theme === 'dark' && !isDarkTheme()) {
    document.body.classList.add('dark')
  }
}

function toggleTheme() {
  localStorage.setItem(themeKey, getTheme() === 'dark' ? 'light' : 'dark')
  setTheme()
}

document.addEventListener('DOMContentLoaded', function () {
  const el = document.getElementById('main')
  el.addEventListener('click', closeNavigation, false)

  setTheme()
})

function logout() {
  localStorage.removeItem('passphrase')
  window.location.href = '/'
}

function showNavigation() {
  const navigation = document.getElementById('navigation')
  navigation.classList.remove('hidden', 'sticky', 'pt-32')
  navigation.classList.add(
    'absolute',
    'right-0',
    'top-0',
    '-mt-0',
    'z-50',
    'pt-0',
    'bg-white',
    'border-l',
    'border-gray-200',
  )
}

function closeNavigation() {
  const navigation = document.getElementById('navigation')
  navigation.classList.add('hidden')
  navigation.classList.remove('absolute', 'right-0', 'z-50', 'bg-gray-100', 'border-r', 'border-gray-800')
}

function toggleLayout(state) {
  if (localStorage.getItem('layout') === 'horizontal') {
    localStorage.setItem('layout', 'vertical')
  } else if (localStorage.getItem('layout') === 'vertical') {
    localStorage.setItem('layout', 'horizontal')
  } else if (!localStorage.getItem('layout')) {
    if (state === 'horizontal') {
      localStorage.setItem('layout', 'vertical')
    } else {
      localStorage.setItem('layout', 'horizontal')
    }
  }

  console.log(localStorage.getItem('layout'))
}
