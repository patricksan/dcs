package com.moogu.dcs.server;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.moogu.dcs.server.feature.management.DcsServletContextListener;
import com.moogu.dcs.server.utils.DateHelper;
import com.moogu.dcs.shared.utils.DcsFormats;

public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = 2966415207758270585L;

	private ApplicationContext applicationContext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getParameter("currencyGroupId");
		req.getParameter("currencyCode");
		final String format = req.getParameter("format");
		// final String screen = req.getParameter("screen");
		final String dayDate = req.getParameter("dayDate");

		// Set format response header
		if (DcsFormats.PDF_FORMAT.equals(format)) {
			resp.setContentType("application/pdf");
			resp.addHeader("Content-Disposition",
					"attachment; filename=report.pdf");
		} else {
			resp.setContentType("application/excel");
			resp.addHeader("Content-Disposition",
					"attachment; filename=report.xls");
		}

		if (dayDate == null) {
			new Date();
		} else {
			DateHelper.parse(dayDate, DcsFormats.DATE_FORMAT);
		}
		// final OutputStream outputStream = resp.getOutputStream();

		// Open transaction
		final PlatformTransactionManager platformTransactionManager = applicationContext
				.getBean(PlatformTransactionManager.class);
		final DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		def.setTimeout(50);
		final TransactionStatus transactionStatus = platformTransactionManager
				.getTransaction(def);

		try {
			// if (OverviewPanel.SCREEN.equals(screen)) {
			// final ReserveEURExcelReportGenerator excelGenerator =
			// applicationContext.getBean(ReserveEURExcelReportGenerator.class);
			// excelGenerator.generateReport(outputStream, req);
			// } else {
			throw new IllegalStateException("No handler for such request");
			// }
			// platformTransactionManager.commit(transactionStatus);
		} catch (final RuntimeException e) {
			platformTransactionManager.rollback(transactionStatus);
			throw e;
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		applicationContext = (ApplicationContext) config.getServletContext()
				.getAttribute(DcsServletContextListener.APP_CONTEXT_NAME);
	}
}