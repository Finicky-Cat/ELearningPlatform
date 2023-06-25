/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecourse.app.student.console;

import eapli.ecourse.app.common.console.ECourseBaseApplication;
import eapli.ecourse.app.student.console.presentation.FrontMenu;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ECoursePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

/**
 * eCourse User Application.
 */
@SuppressWarnings("squid:S106")
public final class ECourseStudentApp extends ECourseBaseApplication {

	/**
	 * Empty constructor is private to avoid instantiation of this class.
	 */
	private ECourseStudentApp() {
	}
	/**
	 * Main method.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args) {

		new ECourseStudentApp().run(args);
	}
	/**
	 * Show the main menu.
	 */
	@Override
	protected void doMain(final String[] args) {
		new FrontMenu().show();
	}
	/**
	 * Return the application title.
	 */
	@Override
	protected String appTitle() {
		return "my eCourse App - Student";
	}
	/**
	 * Return the application closing message.
	 */
	@Override
	protected String appGoodbye() {
		return "Thank you for using 'my eCourse' App!";
	}
	/**
	 * Configure the authorization.
	 */
	@Override
	protected void configureAuthz() {
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new ECoursePasswordPolicy(),
				new PlainTextEncoder());
	}

}
