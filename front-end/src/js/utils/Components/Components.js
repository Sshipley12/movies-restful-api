import Html from "../Html/Html";
import Api from "../Api/Api";
import picture from "../../../images/scenes.jpg";

export default () => new Components();

class Components {
  getAppContext() {
    return Html().select("#app");
  }

  getWrapperDiv() {
    return Html()
      .create("div")
      .addClass("wrapper");
  }
  renderContentBlock(requestedData) {
    const content = Html()
      .create("section")
      .addClass("content");
    const contentTitle = Html()
      .create("h2")
      .addClass("content__title")
      .text(requestedData);
    const cards = Html()
      .create("section")
      .addClass("cards");
    Api().getRequest(
      `http://localhost:8080/api/${requestedData}`,
      responseCollection => {
        responseCollection.forEach(item => {
          let name;
          name = item.name;
          if (item.title) {
            name = item.title;
          }
          let image;
          image = item.imageUrl;
          if (!image) {
            url = picture;
          }

          const contentBlockListListItem = Html()
            .create("li")
            .addClass("content-block__list-item")
            .addChild(
              Html().create(
                "a".addAttribute(
                  "href",
                  `/$(requestedData}/$(item.id)`.text(name).click(event)
                )
              )
            );
        });
      }
    );
  }

  renderMainFooter() {
    const footer = Html()
      .create("footer")
      .addClass("footer");
    const footerCopy = Html()
      .create("small")
      .addClass("footer__text")
      .html("&copy; 2019");
    footer.addChild(footerCopy);
    return footer;
  }

  renderMainHeader() {
    const mainHeader = Html()
      .create("header")
      .addClass("main-header");
    const mainHeaderTitle = Html()
      .create("h1")
      .addClass("main-header__title")
      .text("1-800-Movies");
    const nav = this.renderNav();
    mainHeader.addChild(mainHeaderTitle);
    mainHeader.addChild(nav);
    return mainHeader;
  }

  renderNav() {
    const nav = Html()
      .create("nav")
      .addClass("nav");
    const navList = Html()
      .create("ul")
      .addClass("nav__list");
    const navListItemOne = Html()
      .create("li")
      .addClass("nav__list-item")
      .addChild(
        Html()
          .create("a")
          .addAttribute("href", "#")
          .text("Actors")
          .click(event => {
            event.preventDefault();
            this.renderPageActors();
          })
      );
    const navListItemTwo = Html()
      .create("li")
      .addClass("nav__list-item")
      .addChild(
        Html()
          .create("a")
          .addAttribute("href", "#")
          .text("Movies")
          .click(event => {
            event.preventDefault();
            this.renderPageMovies();
          })
      );
    const navListItemThree = Html()
      .create("li")
      .addClass("nav__list-item")
      .addChild(
        Html()
          .create("a")
          .addAttribute("href", "#")
          .text("Scenes")
          .click(event => {
            event.preventDefault();
            this.renderPageScenes();
          })
      );
    navList.addChild(navListItemOne);
    navList.addChild(navListItemTwo);
    navList.addChild(navListItemThree);
    nav.addChild(navList);
    return nav;
  }

  renderPageActors() {
    const currentMainContentBlock = this.getWrapperDiv().select(".container");
    currentMainContentBlock.replace(this.renderContentBlock("actors"));
  }

  renderPageHome() {
    const app = this.getAppContext();
    const wrapperDiv = this.getWrapperDiv();
    const header = this.renderMainHeader();
    const footer = this.renderMainFooter();
    wrapperDiv.addChild(header);

    wrapperDiv.addChild(footer);
    app.addChild(wrapperDiv);
  }

  renderPageMovies() {}

  renderPageScenes() {}
}
