package dev.chu.mvvm_coroutine_sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.chu.mvvm_coroutine_sample.data.entity.User
import dev.chu.mvvm_coroutine_sample.databinding.ItemUserBinding

class UserAdapter : RecyclerView.Adapter<UserVH>() {
    var users = emptyList<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

class UserVH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
        binding.userName.text = user.name
        binding.userEmail.text = user.email
        binding.userInitial.text = user.name.substring(0, 1)
    }
}