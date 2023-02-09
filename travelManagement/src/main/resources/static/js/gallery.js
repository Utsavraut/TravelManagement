var previous = document.getElementById('btnPrevious')
var next = document.getElementById('btnNext')
var gallery = document.getElementById('image-gallery')
var pageIndicator = document.getElementById('page')
var galleryDots = document.getElementById('gallery-dots');

var images= [ 
    { title: "Image 1", source: "./img/bali.jpg" },
    { title: "Image 2", source: "./img/tokyo.jpg" },
    { title: "Image 3", source: "./img/mustang.jpg" },
    { title: "Image 4", source: "./img/bali.jpg" },
    { title: "Image 5", source: "./img/beach.jpg" },
    { title: "Image 6", source: "./img/city.jpg" },
    { title: "Image 7", source: "./img/paris.jpg" },
    { title: "Image 8", source: "./img/sydney.jpg" },
    { title: "Image 9", source: "./img/newyork.jpg" },
    { title: "Image 10", source: "./img/maldives.jpg" },
    { title: "Image 11", source: "./img/losangeles.jpg" },
    { title: "Image 12", source: "./img/seattle.jpg" },
    { title: "Image 13", source: "./img/london.jpg" },
    { title: "Image 14", source: "./img/amsterdam.jpg" },
    { title: "Image 15", source: "./img/rome.jpg" },
    { title: "Image 16", source: "./img/venice.jpg" },
    { title: "Image 17", source: "./img/prague.jpg" },
    { title: "Image 18", source: "./img/shanghai.jpg" },
    { title: "Image 19", source: "./img/hongkong.jpg" },
    { title: "Image 20", source: "./img/singapore.jpg" }

   ];

var perPage = 10;
var page = 1;
var pages = Math.ceil(images.length / perPage)


// Gallery dots
for (var i = 0; i < pages; i++){
  var dot = document.createElement('button')
  var dotSpan = document.createElement('span')
  var dotNumber = document.createTextNode(i + 1)
  dot.classList.add('gallery-dot');
  dot.setAttribute('data-index', i);
  dotSpan.classList.add('sr-only');
  
  dotSpan.appendChild(dotNumber);
  dot.appendChild(dotSpan)
  
  dot.addEventListener('click', function(e) {
    var self = e.target
    goToPage(self.getAttribute('data-index'))
  })
  
  galleryDots.appendChild(dot)
}

// Previous Button
previous.addEventListener('click', function() {
  if (page === 1) {
    page = 1;
  } else {
    page--;
    showImages();
  }
})

// Next Button
next.addEventListener('click', function() {
  if (page < pages) {
    page++;
    showImages();
  }
})

// Jump to page
function goToPage(index) {
  index = parseInt(index);
  page =  index + 1;
  
  showImages();
}
    
// Load images
function showImages() {
  while(gallery.firstChild) gallery.removeChild(gallery.firstChild)
  
  var offset = (page - 1) * perPage;
  var dots = document.querySelectorAll('.gallery-dot');
  
  for (var i = 0; i < dots.length; i++){
    dots[i].classList.remove('active');
  }
  
  dots[page - 1].classList.add('active');
  
  for (var i = offset; i < offset + perPage; i++) {
    if ( images[i] ) {
      var template = document.createElement('div');
      var title = document.createElement('p');
      var titleText = document.createTextNode(images[i].title);
      var img = document.createElement('img');
      
      template.classList.add('template')
      img.setAttribute("src", images[i].source);
      img.setAttribute('alt', images[i].title);

      title.appendChild(titleText);
      template.appendChild(img);
      template.appendChild(title);
      gallery.appendChild(template);      
    }
  }
  
  // Animate images
  var galleryItems = document.querySelectorAll('.template')
  for (var i = 0; i < galleryItems.length; i++) {
    var onAnimateItemIn = animateItemIn(i);
    setTimeout(onAnimateItemIn, i * 100);
  }
  
  function animateItemIn(i) {
    var item = galleryItems[i];
    return function() {
      item.classList.add('animate');
    }
  }
  
  // Update page indicator
  pageIndicator.textContent = "Page " + page + " of " + pages;
  
}

showImages();