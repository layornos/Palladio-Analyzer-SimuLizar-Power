package de.upb.pcm.interpreter.access;

import de.upb.pcm.interpreter.interpreter.InterpreterDefaultContext;

/**
 * Factory for pcm and pms model accesses and pcm model interpreters.
 * 
 * @author Joachim Meyer
 * 
 */
class ModelAccessFactory implements IModelAccessFactory {
	private final ModelHelper modelHelper;
	private final PMSAccess pmsAccess;
	private final PRMAccess prmAccess;
	private final GlobalPCMAccess globalPCMAccess;
	private final SDAccess sdAccess;

	/**
	 * Constructor
	 * 
	 * @param modelHelper
	 *            the model helper.
	 */
	public ModelAccessFactory(final ModelHelper modelHelper) {
		super();
		this.modelHelper = modelHelper;
		this.pmsAccess = new PMSAccess(modelHelper);
		this.prmAccess = new PRMAccess(modelHelper);
		this.globalPCMAccess = new GlobalPCMAccess(modelHelper);
		this.sdAccess = new SDAccess(modelHelper);
	}

	@Override
	public AllocationAccess getAllocationAccess(
			final InterpreterDefaultContext context) {
		return new AllocationAccess(context, getModelHelper());
	}

	@Override
	public SystemAccess getSystemAccess(final InterpreterDefaultContext context) {
		return new SystemAccess(context, getModelHelper());
	}

	/**
	 * 
	 * @see de.upb.pcm.interpreter.access.IModelAccessFactory#getPCMModelAccess(int,
	 *      de.upb.pcm.interpreter.interpreter.InterpreterDefaultContext)
	 */
	@Override
	public UsageModelAccess getUsageModelAccess(
			final InterpreterDefaultContext context) {
		return new UsageModelAccess(context, getModelHelper());
	}

	@Override
	public RepositoryAccess getRepositoryAccess(
			InterpreterDefaultContext context) {
		return new RepositoryAccess(context, getModelHelper());
	}

	/**
	 * 
	 * @see de.upb.pcm.interpreter.access.IModelAccessFactory#getPMSModelAccess()
	 */
	@Override
	public PMSAccess getPMSModelAccess() {
		return this.pmsAccess;
	}

	@Override
	public PRMAccess getPRMModelAccess() {
		return this.prmAccess;
	}
	
	@Override
	public GlobalPCMAccess getGlobalPCMAccess() {
		return this.globalPCMAccess;
	}

	@Override
	public SDAccess getSDAccess() {
		return this.sdAccess;
	}

	/**
	 * @return the modelHelper.
	 */
	private ModelHelper getModelHelper() {
		return this.modelHelper;
	}

}