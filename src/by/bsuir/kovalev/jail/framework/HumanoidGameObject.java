package by.bsuir.kovalev.jail.framework;

public abstract class HumanoidGameObject extends GameObject{

	protected boolean isJumping;
	
	public HumanoidGameObject(int x, int y, ObjectId objectId) {
		super(x, y, objectId);
		this.isJumping = false;
		this.isFalling = true;
	}
	
	public boolean isJumping() {
		return isJumping;
	}

	public void setIsJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

}
