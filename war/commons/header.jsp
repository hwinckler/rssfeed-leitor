    <!-- Static navbar -->
    <nav class="navbar navbar-default ">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">FeedReader</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="${param.opt == 'index' ? 'active' : ''}"><a href="index">Home</a></li>
            <li class="${param.opt == 'about' ? 'active' : ''}"><a href="about.jsp">About</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
              <li class="">
                <p class="navbar-btn">
                  <a class="btn btn-primary ${param.opt == 'category' ? 'active' : ''}" href="category" role="button">Category</a>
                  <a class="btn btn-primary ${param.opt == 'feed' ? 'active' : ''}" href="feed" role="button">Feed</a>
                </p>
              </li>
            </ul>
        </div><!--/.nav-collapse -->
      </div><!--/.container-fluid -->
    </nav>