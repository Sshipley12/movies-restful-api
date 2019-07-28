import Html from "../Html/Html";
import Api from "../Api/Api";

export default () => new Components();

class Components {
	getAppContext() {
		return Html().select("#app");
	}

	getWrapperDiv() {
		return Html().create("div").addClass("wrapper");
	}

	renderMainFooter() {
		const footer = Html().create("footer").addClass("footer");
		const footerCopy = Html().create("small").addClass("footer__text").html("&copy; 2019");
		footer.addChild(footerCopy);
		return footer;
	}

	renderMainHeader() {
		const mainHeader = Html().create("header").addClass("main-header");
		const mainHeaderTitle = Html().create("h1").addClass("main-header__title").text('1-800-Movies');
		const nav = this.renderNav();
		mainHeader.addChild(mainHeaderTitle);
		mainHeader.addChild(nav);
		return mainHeader;
	}

	renderNav() {
		const nav = Html().create('nav').addClass('nav');
		const navList = Html().create('ul').addClass('nav__list');
		const navListItemOne = Html().create('li').addClass('nav__list-item').addChild(Html().create('a')
			.addAttribute('href', '#').text('Actors')
			.click((event) => {
				event.preventDefault();
				this.renderPageActors();
			}));
		const navListItemTwo = Html().create('li').addClass('nav__list-item').addChild(Html().create('a')
			.addAttribute('href', '#').text('Movies')
			.click((event) => {
				event.preventDefault();
				this.renderPageMovies();
			}));
		const navListItemThree = Html().create('li').addClass('nav__list-item').addChild(Html().create('a')
			.addAttribute('href', '#').text('Scenes')
			.click((event) => {
				event.preventDefault();
				this.renderPageScenes();
			}));
		navList.addChild(navListItemOne);
		navList.addChild(navListItemTwo);
		navList.addChild(navListItemThree);
		nav.addChild(navList);
		return nav;
	}

	renderPageActors() {

	}

	renderPageHome() {
		const app = this.getAppContext();
		const wrapperDiv = this.getWrapperDiv();
		const header = this.renderMainHeader();
		const footer = this.renderMainFooter();
		wrapperDiv.addChild(header)


		wrapperDiv.addChild(footer);
		app.addChild(wrapperDiv);
	}

	renderPageMovies() {

	}

	renderPageScenes() {

	}

}
